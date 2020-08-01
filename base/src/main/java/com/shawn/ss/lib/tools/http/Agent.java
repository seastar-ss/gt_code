/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools.http;

/**
 *
 * @author ss
 */
public enum Agent {

    mobile() {
                final String[] agents = {
                    "Mozilla/5.0 (Linux; Android 4.4.2; HUAWEI P6-C00 Build/HuaweiP6-C00) AppleWebKit/537.36 (KHTML,like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 V1_AND_SQ_5.3.2_204_YYB_D QQ/5.3.2.2355 NetType/WIFI",
                    "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12A405 NetType/WIFI",
                    "Mozilla/5.0 (Linux; U; Android 4.1.2; zh-cn; Qmi Build/MocorDroid4.1.2) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.2.0_174_YYB_D QQ/5.2.0.2280 NetType/3G",
                    "Mozilla/5.0 (Linux; U; Android 4.0.4; zh-cn; HUAWEI U9508 Build/HuaweiU9508) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.2.0_174_YYB_D QQ/5.2.0.2280 NetType/WIFI",
                    "Mozilla/5.0 (iPod touch; CPU iPhone OS 8_1 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12B411 QQ/5.1.1.97",
                    "Mozilla/5.0 (Linux; U; Android 4.2.1; zh-cn; R819T Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.1.1_158_YYB_D QQ/5.1.1.2245",
                    "Mozilla/5.0 (Linux; Android 4.4.2; SM-N9006 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 NetType/3gnet",
                    "Mozilla/5.0 (Linux; U; Android 4.2.2; zh-cn; 2014011 Build/HM2014011) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.1.0_156_YYB_D QQ/5.1.0.2240",
                    "Mozilla/5.0 (Linux; U; Android 4.1.1; zh-cn; U705T Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.2.0_174_YYB_D QQ/5.2.0.2280 NetType/WIFI",
                    "Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; HUAWEI Y325-T00 Build/HUAWEIY325-T00) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 V1_AND_SQ_5.2.0_174_YYB_D QQ/5.2.0.2280 NetType/WIFI",
                    "Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; koobee M2 Build/JLS36C) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 MQQBrowser/5.4 Mobile Safari/533.1 V1_AND_SQ_5.1.1_158_YYB_D QQ/5.1.1.2245",
                    "Mozilla/5.0 (Linux; Android 4.4.2; D2533 Build/19.2.A.0.362) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 V1_AND_SQI_5.0.10_0_YYB_D QQ/5.0.10.6046",
                    "Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; R831S Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.1.1_158_YYB_D QQ/5.1.1.2245",
                    "Mozilla/5.0 (Linux; U; Android 4.2.1; zh-cn; Lenovo A670t Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.2.0_174_YYB_D QQ/5.2.0.2280 NetType/3G",
                    "Mozilla/5.0 (Linux; U; Android 4.2.2; zh-cn; HUAWEI G750-T20 Build/HuaweiG750-T20) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 MQQBrowser/5.4 Mobile Safari/533.1 V1_AND_SQ_5.1.2_160_YYB_D QQ/5.1.1.2250",
                    "Mozilla/5.0 (Linux; U; Android 4.1.2; zh-cn; Qmi Build/MocorDroid4.1.2) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.2.0_174_YYB_D QQ/5.2.0.2280 NetType/3G",
                    "Mozilla/5.0 (Linux; U; Android 4.0.4; zh-cn; HUAWEI U9508 Build/HuaweiU9508) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 V1_AND_SQ_5.2.0_174_YYB_D QQ/5.2.0.2280 NetType/WIFI"
                };

                @Override
                public String getUAString() {

                    int i = (int) Math.floor(Math.random() * agents.length);
                    return agents[i];
                }
            },
    pc() {

                final String[] agents = {
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36 TheWorld 6",
                    "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36",
                    "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36",
                    "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36 TheWorld 6",
                    "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.111 Safari/537.36"
                };

                @Override
                public String getUAString() {
                    int i = (int) Math.floor(Math.random() * agents.length);
                    return agents[i];
                }
            };

    public abstract String getUAString();
}
