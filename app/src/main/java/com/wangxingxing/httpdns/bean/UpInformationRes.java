package com.wangxingxing.httpdns.bean;


public class UpInformationRes {
    private int code;
    private String message;
    private int ttl;
    private DataDTO data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        private int mid;
        private String name;
        private String sex;
        private String face;
        private String sign;
        private int rank;
        private int level;
        private int jointime;
        private int moral;
        private int silence;
        private String birthday;
        private int coins;
        private boolean fans_badge;
        private OfficialDTO official;
        private VipDTO vip;
        private PendantDTO pendant;
        private NameplateDTO nameplate;
        private UserHonourInfoDTO user_honour_info;
        private boolean is_followed;
        private String top_photo;
        private ThemeDTO theme;
        private SysNoticeDTO sys_notice;
        private LiveRoomDTO live_room;

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getJointime() {
            return jointime;
        }

        public void setJointime(int jointime) {
            this.jointime = jointime;
        }

        public int getMoral() {
            return moral;
        }

        public void setMoral(int moral) {
            this.moral = moral;
        }

        public int getSilence() {
            return silence;
        }

        public void setSilence(int silence) {
            this.silence = silence;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getCoins() {
            return coins;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public boolean isFans_badge() {
            return fans_badge;
        }

        public void setFans_badge(boolean fans_badge) {
            this.fans_badge = fans_badge;
        }

        public OfficialDTO getOfficial() {
            return official;
        }

        public void setOfficial(OfficialDTO official) {
            this.official = official;
        }

        public VipDTO getVip() {
            return vip;
        }

        public void setVip(VipDTO vip) {
            this.vip = vip;
        }

        public PendantDTO getPendant() {
            return pendant;
        }

        public void setPendant(PendantDTO pendant) {
            this.pendant = pendant;
        }

        public NameplateDTO getNameplate() {
            return nameplate;
        }

        public void setNameplate(NameplateDTO nameplate) {
            this.nameplate = nameplate;
        }

        public UserHonourInfoDTO getUser_honour_info() {
            return user_honour_info;
        }

        public void setUser_honour_info(UserHonourInfoDTO user_honour_info) {
            this.user_honour_info = user_honour_info;
        }

        public boolean isIs_followed() {
            return is_followed;
        }

        public void setIs_followed(boolean is_followed) {
            this.is_followed = is_followed;
        }

        public String getTop_photo() {
            return top_photo;
        }

        public void setTop_photo(String top_photo) {
            this.top_photo = top_photo;
        }

        public ThemeDTO getTheme() {
            return theme;
        }

        public void setTheme(ThemeDTO theme) {
            this.theme = theme;
        }

        public SysNoticeDTO getSys_notice() {
            return sys_notice;
        }

        public void setSys_notice(SysNoticeDTO sys_notice) {
            this.sys_notice = sys_notice;
        }

        public LiveRoomDTO getLive_room() {
            return live_room;
        }

        public void setLive_room(LiveRoomDTO live_room) {
            this.live_room = live_room;
        }

        public static class OfficialDTO {
            private int role;
            private String title;
            private String desc;
            private int type;

            public int getRole() {
                return role;
            }

            public void setRole(int role) {
                this.role = role;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class VipDTO {
            private int type;
            private int status;
            private long due_date;
            private int vip_pay_type;
            private int theme_type;
            private LabelDTO label;
            private int avatar_subscript;
            private String nickname_color;
            private int role;
            private String avatar_subscript_url;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public long getDue_date() {
                return due_date;
            }

            public void setDue_date(long due_date) {
                this.due_date = due_date;
            }

            public int getVip_pay_type() {
                return vip_pay_type;
            }

            public void setVip_pay_type(int vip_pay_type) {
                this.vip_pay_type = vip_pay_type;
            }

            public int getTheme_type() {
                return theme_type;
            }

            public void setTheme_type(int theme_type) {
                this.theme_type = theme_type;
            }

            public LabelDTO getLabel() {
                return label;
            }

            public void setLabel(LabelDTO label) {
                this.label = label;
            }

            public int getAvatar_subscript() {
                return avatar_subscript;
            }

            public void setAvatar_subscript(int avatar_subscript) {
                this.avatar_subscript = avatar_subscript;
            }

            public String getNickname_color() {
                return nickname_color;
            }

            public void setNickname_color(String nickname_color) {
                this.nickname_color = nickname_color;
            }

            public int getRole() {
                return role;
            }

            public void setRole(int role) {
                this.role = role;
            }

            public String getAvatar_subscript_url() {
                return avatar_subscript_url;
            }

            public void setAvatar_subscript_url(String avatar_subscript_url) {
                this.avatar_subscript_url = avatar_subscript_url;
            }

            public static class LabelDTO {
                private String path;
                private String text;
                private String label_theme;
                private String text_color;
                private int bg_style;
                private String bg_color;
                private String border_color;

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getLabel_theme() {
                    return label_theme;
                }

                public void setLabel_theme(String label_theme) {
                    this.label_theme = label_theme;
                }

                public String getText_color() {
                    return text_color;
                }

                public void setText_color(String text_color) {
                    this.text_color = text_color;
                }

                public int getBg_style() {
                    return bg_style;
                }

                public void setBg_style(int bg_style) {
                    this.bg_style = bg_style;
                }

                public String getBg_color() {
                    return bg_color;
                }

                public void setBg_color(String bg_color) {
                    this.bg_color = bg_color;
                }

                public String getBorder_color() {
                    return border_color;
                }

                public void setBorder_color(String border_color) {
                    this.border_color = border_color;
                }
            }
        }

        public static class PendantDTO {
            private int pid;
            private String name;
            private String image;
            private int expire;
            private String image_enhance;
            private String image_enhance_frame;

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getExpire() {
                return expire;
            }

            public void setExpire(int expire) {
                this.expire = expire;
            }

            public String getImage_enhance() {
                return image_enhance;
            }

            public void setImage_enhance(String image_enhance) {
                this.image_enhance = image_enhance;
            }

            public String getImage_enhance_frame() {
                return image_enhance_frame;
            }

            public void setImage_enhance_frame(String image_enhance_frame) {
                this.image_enhance_frame = image_enhance_frame;
            }
        }

        public static class NameplateDTO {
            private int nid;
            private String name;
            private String image;
            private String image_small;
            private String level;
            private String condition;

            public int getNid() {
                return nid;
            }

            public void setNid(int nid) {
                this.nid = nid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getImage_small() {
                return image_small;
            }

            public void setImage_small(String image_small) {
                this.image_small = image_small;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getCondition() {
                return condition;
            }

            public void setCondition(String condition) {
                this.condition = condition;
            }
        }

        public static class UserHonourInfoDTO {
        }

        public static class ThemeDTO {
        }

        public static class SysNoticeDTO {
        }

        public static class LiveRoomDTO {
            private int roomStatus;
            private int liveStatus;
            private String url;
            private String title;
            private String cover;
            private int online;
            private int roomid;
            private int roundStatus;
            private int broadcast_type;

            public int getRoomStatus() {
                return roomStatus;
            }

            public void setRoomStatus(int roomStatus) {
                this.roomStatus = roomStatus;
            }

            public int getLiveStatus() {
                return liveStatus;
            }

            public void setLiveStatus(int liveStatus) {
                this.liveStatus = liveStatus;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public int getRoomid() {
                return roomid;
            }

            public void setRoomid(int roomid) {
                this.roomid = roomid;
            }

            public int getRoundStatus() {
                return roundStatus;
            }

            public void setRoundStatus(int roundStatus) {
                this.roundStatus = roundStatus;
            }

            public int getBroadcast_type() {
                return broadcast_type;
            }

            public void setBroadcast_type(int broadcast_type) {
                this.broadcast_type = broadcast_type;
            }
        }
    }


    //https://api.bilibili.com/x/space/acc/info?mid=191622&jsonp=jsonp
   //{"code":0,"message":"0","ttl":1,"data":{"mid":191622,"name":"A7uKas","sex":"男","face":"http://i0.hdslb.com/bfs/face/24ce9979bac20ecb3c6dfb28604aa6f2d21988b1.jpg","sign":"这个人很懒，什么也没有留下~","rank":10000,"level":6,"jointime":0,"moral":0,"silence":0,"birthday":"02-06","coins":0,"fans_badge":false,"official":{"role":0,"title":"","desc":"","type":-1},"vip":{"type":2,"status":1,"due_date":1624723200000,"vip_pay_type":0,"theme_type":0,"label":{"path":"","text":"年度大会员","label_theme":"annual_vip","text_color":"#FFFFFF","bg_style":1,"bg_color":"#FB7299","border_color":""},"avatar_subscript":1,"nickname_color":"#FB7299","role":3,"avatar_subscript_url":"http://i0.hdslb.com/bfs/vip/icon_Certification_big_member_22_3x.png"},"pendant":{"pid":147,"name":"国民老公带回家","image":"http://i0.hdslb.com/bfs/face/1cdf174c75dd6493f3c8f0797e972b69e3293870.png","expire":0,"image_enhance":"http://i0.hdslb.com/bfs/face/1cdf174c75dd6493f3c8f0797e972b69e3293870.png","image_enhance_frame":""},"nameplate":{"nid":0,"name":"","image":"","image_small":"","level":"","condition":""},"user_honour_info":{"mid":0,"colour":null,"tags":null},"is_followed":false,"top_photo":"http://i2.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png","theme":{},"sys_notice":{},"live_room":{"roomStatus":1,"liveStatus":0,"url":"https://live.bilibili.com/6923645","title":"","cover":"","online":0,"roomid":6923645,"roundStatus":0,"broadcast_type":0}}}


}
