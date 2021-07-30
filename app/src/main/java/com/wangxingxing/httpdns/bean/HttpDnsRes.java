package com.wangxingxing.httpdns.bean;

import java.util.List;

public class HttpDnsRes {
    /***
     * {
     *     "dns": [
     *         {
     *             "host": "app.bilibili.com",
     *             "client_ip": "120.243.2.74",
     *             "ips": [
     *                 "112.25.54.211",
     *                 "112.16.2.206",
     *                 "112.25.54.212",
     *                 "112.16.2.205"
     *             ],
     *             "type": 1,
     *             "ttl": 33,
     *             "origin_ttl": 60
     *         },
     *         {
     *             "host": "api.bilibili.com",
     *             "client_ip": "120.243.2.74",
     *             "ips": [
     *                 "119.3.70.188",
     *                 "120.92.174.135",
     *                 "36.156.48.34",
     *                 "36.156.48.33",
     *                 "36.156.48.36",
     *                 "36.156.48.35"
     *             ],
     *             "type": 1,
     *             "ttl": 15,
     *             "origin_ttl": 60
     *         }
     *     ]
     * }
     */
    private List<DnsBean> dns;

    public List<DnsBean> getDns() {
        return dns;
    }

    public void setDns(List<DnsBean> dns) {
        this.dns = dns;
    }

    public static class DnsBean {

        public DnsBean() {
            this.time = System.currentTimeMillis();
        }

        /**
         * host : api.bilibili.com
         * client_ip : 58.49.114.214
         * ips : ["116.207.118.12"]
         * ttl : 123
         * origin_ttl : 180
         */


        private String host;
        private String client_ip;
        private int ttl;
        private int origin_ttl;
        private List<String> ips;
        private long time;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getClient_ip() {
            return client_ip;
        }

        public void setClient_ip(String client_ip) {
            this.client_ip = client_ip;
        }

        public int getTtl() {
            return ttl;
        }

        public void setTtl(int ttl) {
            this.ttl = ttl;
        }

        public int getOrigin_ttl() {
            return origin_ttl;
        }

        public void setOrigin_ttl(int origin_ttl) {
            this.origin_ttl = origin_ttl;
        }

        public List<String> getIps() {
            return ips;
        }

        public void setIps(List<String> ips) {
            this.ips = ips;
        }

        public long getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
