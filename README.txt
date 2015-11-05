keytool -genkey -v -alias tomcat -keyalg RSA -keystore D:\tomcat.keystore -validity 36500
keytool -genkey -v -alias lorren -keyalg RSA -storetype PKCS12 -keystore D:\lorren.p12

keytool -export -alias lorren -keystore D:\lorren.p12 -storetype PKCS12 -storepass lorren -rfc -file D:\lorren.cer
keytool -import -v -file D:\lorren.cer -keystore D:\tomcat.keystore

keytool -list -keystore D:\tomcat.keystore

#受信任的根证书颁发机构
keytool -keystore D:\tomcat.keystore -export -alias tomcat -file D:\tomcat.cer

<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
    SSLEnabled="true" maxThreads="150" scheme="https"
    secure="true" clientAuth="true" sslProtocol="TLS"
    keystoreFile="D:\\tomcat.keystore" keystorePass="lorren"
    truststoreFile="D:\\tomcat.keystore" truststorePass="lorren"
/>