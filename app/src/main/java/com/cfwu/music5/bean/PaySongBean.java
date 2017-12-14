package com.cfwu.music5.bean;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * author：agxxxx on 2017/3/3 10:49
 * email：agxxxx@126.com
 * blog: http://blog.csdn.net/zuiaisha1
 * github: https://github.com/agxxxx
 * Created by Administrator on 2017/3/3.
 */

public class PaySongBean implements Parcelable{

    public String error_code;
    public BitrateBean bitrate;
    public SonginfoBean songinfo;

    protected PaySongBean(Parcel in) {
        error_code = in.readString();
    }

    public static final Creator<PaySongBean> CREATOR = new Creator<PaySongBean>() {
        @Override
        public PaySongBean createFromParcel(Parcel in) {
            return new PaySongBean(in);
        }

        @Override
        public PaySongBean[] newArray(int size) {
            return new PaySongBean[size];
        }
    };

    @Override
    public String toString() {
        return "PaySongBean{" +
                "error_code='" + error_code + '\'' +
                ", bitrate=" + bitrate +
                ", songinfo=" + songinfo +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(error_code);
    }

    public static class BitrateBean implements Parcelable {
        public String file_bitrate;
        public String free;
        public String file_link;
        public String file_extension;
        public String original;
        public String file_size;
        public String file_duration;
        public String show_link;
        public String song_file_id;
        public String replay_gain;

        protected BitrateBean(Parcel in) {
            file_bitrate = in.readString();
            free = in.readString();
            file_link = in.readString();
            file_extension = in.readString();
            original = in.readString();
            file_size = in.readString();
            file_duration = in.readString();
            show_link = in.readString();
            song_file_id = in.readString();
            replay_gain = in.readString();
        }

        public static final Creator<BitrateBean> CREATOR = new Creator<BitrateBean>() {
            @Override
            public BitrateBean createFromParcel(Parcel in) {
                return new BitrateBean(in);
            }

            @Override
            public BitrateBean[] newArray(int size) {
                return new BitrateBean[size];
            }
        };

        @Override
        public String toString() {
            return "BitrateBean{" +
                    "file_bitrate='" + file_bitrate + '\'' +
                    ", free='" + free + '\'' +
                    ", file_link='" + file_link + '\'' +
                    ", file_extension='" + file_extension + '\'' +
                    ", original='" + original + '\'' +
                    ", file_size='" + file_size + '\'' +
                    ", file_duration='" + file_duration + '\'' +
                    ", show_link='" + show_link + '\'' +
                    ", song_file_id='" + song_file_id + '\'' +
                    ", replay_gain='" + replay_gain + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(file_bitrate);
            dest.writeString(free);
            dest.writeString(file_link);
            dest.writeString(file_extension);
            dest.writeString(original);
            dest.writeString(file_size);
            dest.writeString(file_duration);
            dest.writeString(show_link);
            dest.writeString(song_file_id);
            dest.writeString(replay_gain);
        }
    }
    public static class SonginfoBean implements Parcelable{
        public String artist_id;
        public String all_artist_id;
        public String album_no;
        public String pic_big;
        public String pic_small;
        public String relate_status;
        public String resource_type;
        public String copy_type;
        public String lrclink;
        public String pic_radio;
        public String toneid;
        public String all_rate;
        public String play_type;
        public String has_mv_mobile;
        public String pic_premium;
        public String pic_huge;
        public String resource_type_ext;
        public String bitrate_fee;
        public String publishtime;
        public String si_presale_flag;
        public String del_status;
        public String song_id;
        public String title;
        public String ting_uid;
        public String author;
        public String album_id;
        public String album_title;
        public String is_first_publish;
        public String havehigh;
        public String charge;
        public String has_mv;
        public String learn;
        public String song_source;
        public String piao_id;
        public String korean_bb_song;
        public String mv_provider;
        public String special_type;
        public String collect_num;
        public String share_num;
        public String comment_num;

        protected SonginfoBean(Parcel in) {
            artist_id = in.readString();
            all_artist_id = in.readString();
            album_no = in.readString();
            pic_big = in.readString();
            pic_small = in.readString();
            relate_status = in.readString();
            resource_type = in.readString();
            copy_type = in.readString();
            lrclink = in.readString();
            pic_radio = in.readString();
            toneid = in.readString();
            all_rate = in.readString();
            play_type = in.readString();
            has_mv_mobile = in.readString();
            pic_premium = in.readString();
            pic_huge = in.readString();
            resource_type_ext = in.readString();
            bitrate_fee = in.readString();
            publishtime = in.readString();
            si_presale_flag = in.readString();
            del_status = in.readString();
            song_id = in.readString();
            title = in.readString();
            ting_uid = in.readString();
            author = in.readString();
            album_id = in.readString();
            album_title = in.readString();
            is_first_publish = in.readString();
            havehigh = in.readString();
            charge = in.readString();
            has_mv = in.readString();
            learn = in.readString();
            song_source = in.readString();
            piao_id = in.readString();
            korean_bb_song = in.readString();
            mv_provider = in.readString();
            special_type = in.readString();
            collect_num = in.readString();
            share_num = in.readString();
            comment_num = in.readString();
        }

        public static final Creator<SonginfoBean> CREATOR = new Creator<SonginfoBean>() {
            @Override
            public SonginfoBean createFromParcel(Parcel in) {
                return new SonginfoBean(in);
            }

            @Override
            public SonginfoBean[] newArray(int size) {
                return new SonginfoBean[size];
            }
        };

        @Override
        public String toString() {
            return "SonginfoBean{" +
                    "artist_id='" + artist_id + '\'' +
                    ", all_artist_id='" + all_artist_id + '\'' +
                    ", album_no='" + album_no + '\'' +
                    ", pic_big='" + pic_big + '\'' +
                    ", pic_small='" + pic_small + '\'' +
                    ", relate_status='" + relate_status + '\'' +
                    ", resource_type='" + resource_type + '\'' +
                    ", copy_type='" + copy_type + '\'' +
                    ", lrclink='" + lrclink + '\'' +
                    ", pic_radio='" + pic_radio + '\'' +
                    ", toneid='" + toneid + '\'' +
                    ", all_rate='" + all_rate + '\'' +
                    ", play_type='" + play_type + '\'' +
                    ", has_mv_mobile='" + has_mv_mobile + '\'' +
                    ", pic_premium='" + pic_premium + '\'' +
                    ", pic_huge='" + pic_huge + '\'' +
                    ", resource_type_ext='" + resource_type_ext + '\'' +
                    ", bitrate_fee='" + bitrate_fee + '\'' +
                    ", publishtime='" + publishtime + '\'' +
                    ", si_presale_flag='" + si_presale_flag + '\'' +
                    ", del_status='" + del_status + '\'' +
                    ", song_id='" + song_id + '\'' +
                    ", title='" + title + '\'' +
                    ", ting_uid='" + ting_uid + '\'' +
                    ", author='" + author + '\'' +
                    ", album_id='" + album_id + '\'' +
                    ", album_title='" + album_title + '\'' +
                    ", is_first_publish='" + is_first_publish + '\'' +
                    ", havehigh='" + havehigh + '\'' +
                    ", charge='" + charge + '\'' +
                    ", has_mv='" + has_mv + '\'' +
                    ", learn='" + learn + '\'' +
                    ", song_source='" + song_source + '\'' +
                    ", piao_id='" + piao_id + '\'' +
                    ", korean_bb_song='" + korean_bb_song + '\'' +
                    ", mv_provider='" + mv_provider + '\'' +
                    ", special_type='" + special_type + '\'' +
                    ", collect_num='" + collect_num + '\'' +
                    ", share_num='" + share_num + '\'' +
                    ", comment_num='" + comment_num + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(artist_id);
            dest.writeString(all_artist_id);
            dest.writeString(album_no);
            dest.writeString(pic_big);
            dest.writeString(pic_small);
            dest.writeString(relate_status);
            dest.writeString(resource_type);
            dest.writeString(copy_type);
            dest.writeString(lrclink);
            dest.writeString(pic_radio);
            dest.writeString(toneid);
            dest.writeString(all_rate);
            dest.writeString(play_type);
            dest.writeString(has_mv_mobile);
            dest.writeString(pic_premium);
            dest.writeString(pic_huge);
            dest.writeString(resource_type_ext);
            dest.writeString(bitrate_fee);
            dest.writeString(publishtime);
            dest.writeString(si_presale_flag);
            dest.writeString(del_status);
            dest.writeString(song_id);
            dest.writeString(title);
            dest.writeString(ting_uid);
            dest.writeString(author);
            dest.writeString(album_id);
            dest.writeString(album_title);
            dest.writeString(is_first_publish);
            dest.writeString(havehigh);
            dest.writeString(charge);
            dest.writeString(has_mv);
            dest.writeString(learn);
            dest.writeString(song_source);
            dest.writeString(piao_id);
            dest.writeString(korean_bb_song);
            dest.writeString(mv_provider);
            dest.writeString(special_type);
            dest.writeString(collect_num);
            dest.writeString(share_num);
            dest.writeString(comment_num);
        }
    }
}
