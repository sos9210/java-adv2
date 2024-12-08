package was.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String path;

    private final Map<String, String> queryParameters = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    //HTTP 메세지 파싱
    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseHeaders(reader);

    }
    // GET /search?q=hello HTTP/1.1
    private void parseRequestLine(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();
        if( requestLine == null ) throw new IOException("EOF: No request line received");

        String[] parts = requestLine.split(" ");
        if( parts.length != 3) throw new IOException("Invalid request line: " + requestLine);

        method = parts[0];
        // /search?q=hello
        String[] pathParts = parts[1].split("\\?");
        // /search
        path = pathParts[0];


        //파라미터가 존재하면
        if(pathParts.length > 1) {
            //쿼리파라미터 파싱
            parseQueryParameters(pathParts[1]);
        }
    }
    //q=hello
    //key1=value1&key2=value2
    //q=
    private void parseQueryParameters(String queryString) {
        for (String param : queryString.split("&")) {
            String[] keyValue = param.split("=");

            //한글이 들어오는경우를 위해 URLDecoder 사용
            String key = URLDecoder.decode(keyValue[0], StandardCharsets.UTF_8);

            //키값만 있고 비어있는경우 ( q= )
            String value = keyValue.length > 1 ? URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8) : "";

            queryParameters.put(key, value);
        }
    }

    // Host: localhost
    // Connection: keep-alive
    // Cache-Control: max-age=0
    private void parseHeaders(BufferedReader reader) throws IOException {
        String line;
        while((line = reader.readLine()) != null) {
            String[] headerParts = line.split(":");
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }
    }

    public String getMethod() {
        return method;
    }
    public String getPath() {
        return path;
    }

    public String getParameter(String name) {
        return queryParameters.get(name);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParameters=" + queryParameters +
                ", headers=" + headers +
                '}';
    }
}
