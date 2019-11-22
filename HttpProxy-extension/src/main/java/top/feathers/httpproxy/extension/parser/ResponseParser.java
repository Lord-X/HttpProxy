package top.feathers.httpproxy.extension.parser;

/**
 * Description:
 *
 * @author zhiminxu
 * @package top.feathers.httpproxy.extension.parser
 * @create_time 2019-11-22
 */
public interface ResponseParser extends Parser {

    ProxyResponse parseResponse(String body);
}
