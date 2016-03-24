###ping++ java SDK 使用文档

- 接入准备

#####apiKey 和 appId

    sdk需要ping++提供的APIKey 和 AppId作为凭证获取移动端支付所需的charge对象。
    其中，APIKey 可以在ping++ 管理平台的【基本信息】中得到。
    AppId 可以在ping++ 管理平台【应用名称】->【应用信息】中得得到。


####依赖包
    
     gons-2.2.4.jar 或更高版本
     pingpp-java-2.0.1.jar  或更高版本
     
####设置apiKey
 
     Pingpp.apiKey = "YOUR-KEY";
     
     在获得charge前，请设置aipKey。
     
####接受请求
 
     客户端会向服务端发送一个带有json对象的post请求，用来请求charge对象。
     json对象格式如下：
     {
      "amount": 10,
      "order_no": "1234567890",
      "channel": "alipay"
     }
     
#####备注

     amount   ：int 类型，表示支付的金额，以分为单位。
     order_no ：String 类型，表示订单号，由字母和数字组成8-20位。
     channel  ：String 类型，表示支付渠道。
     
     以上字段详细说明可以参考ping++ 【文档】-> 【api文档】-> 【创建charge】。
     
#####获得charge
 
    Map<String, Object> chargeMap = new HashMap<String, Object>();
    //某些渠道需要添加extra参数，具体参数详见接口文档
    chargeMap.put("amount", 100);
    chargeMap.put("currency", "cny");
    chargeMap.put("subject", "Your Subject");
    chargeMap.put("body", "Your Body");
    chargeMap.put("order_no", "123456789");
    chargeMap.put("channel", "alipay");
    chargeMap.put("client_ip", "127.0.0.1");
    Map<String, String> app = new HashMap<String, String>();
    app.put("id", "YOUR-APP-ID");
    chargeMap.put("app", app);
    try {
        //发起交易请求
        Charge charge = Charge.create(chargeMap);
        System.out.println(charge);
    } catch (PingppException e) {
        e.printStackTrace();
    }
#####备注
    
    获得charge对象，必须的参数有amount、currency、subject、body、order_no、channel、client_ip、app 这8个参数。
    其中amount、order_no、channel 三个参数由客户端的post请求中获得。
    client_ip 从客户端的request请求中解析。
    currency 为交易的货币代码，目前仅支持人民币cny。
    app 参数为一个包含appId的map对象。
    subject 和 body 参数用来在用户付款、以及在第三方支付软件的账单显示。
    
####返回charge

    请用Json格式把charge对象返回给客户端。
    
###### servlet 返回charge时注意配置

    response.setContentType("application/json;charset=UTF-8");
    
##### struct2  获得post请求参数，建议使用struct2-json-pligun.jar 。返回的result的type设置为json
    
    struct2.xml 配置如下：
    <package name="default" namespace="/" extends="json-default">
        <action name="ActionName" class="ActionCalss" method="Method">
            <interceptor-ref name="json"/>
            <result name="success" type="json">
                <param name="root">charge</param>
            </result>
        </action>
    </package>
 
####补充   
 
     SDK 根目录下面的example目录下提供了一个eclipse工程，里面含有部分操作的示例程序，供开发者参考
    
    
  
 
    
    
