package com.spring.managementProject.form;

import java.util.Date;
 
public class DocumentForm {
	 
    int document_seq;
    int document_re_ref;
    int document_re_lev;
    int document_re_seq;
    String document_writer;
    String document_subject;
    String document_content;
    int document_hits;
    String del_yn;
    String ins_user_id;
    Date ins_date;
    String upd_user_id;
    Date upd_date;
    String search_type;
 
    public int getDocument_seq() {
        return document_seq;
    }
 
    public void setDocument_seq(int document_seq) {
        this.document_seq = document_seq;
    }
 
    public int getDocument_re_ref() {
        return document_re_ref;
    }
 
    public void setDocument_re_ref(int document_re_ref) {
        this.document_re_ref = document_re_ref;
    }
 
    public int getDocument_re_lev() {
        return document_re_lev;
    }
 
    public void setDocument_re_lev(int document_re_lev) {
        this.document_re_lev = document_re_lev;
    }
 
    public int getDocument_re_seq() {
        return document_re_seq;
    }
 
    public void setDocument_re_seq(int document_re_seq) {
        this.document_re_seq = document_re_seq;
    }
 
    public String getDocument_writer() {
        return document_writer;
    }
 
    public void setDocument_writer(String document_writer) {
        this.document_writer = document_writer;
    }
 
    public String getDocument_subject() {
        return document_subject;
    }
 
    public void setDocument_subject(String document_subject) {
        this.document_subject = document_subject;
    }
 
    public String getDocument_content() {
        return document_content;
    }
 
    public void setDocument_content(String document_content) {
        this.document_content = document_content;
    }
 
    public int getDocument_hits() {
        return document_hits;
    }
 
    public void setDocument_hits(int document_hits) {
        this.document_hits = document_hits;
    }
 
    public String getDel_yn() {
        return del_yn;
    }
 
    public void setDel_yn(String del_yn) {
        this.del_yn = del_yn;
    }
 
    public String getIns_user_id() {
        return ins_user_id;
    }
 
    public void setIns_user_id(String ins_user_id) {
        this.ins_user_id = ins_user_id;
    }
 
    public Date getIns_date() {
        return ins_date;
    }
 
    public void setIns_date(Date ins_date) {
        this.ins_date = ins_date;
    }
 
    public String getUpd_user_id() {
        return upd_user_id;
    }
 
    public void setUpd_user_id(String upd_user_id) {
        this.upd_user_id = upd_user_id;
    }
 
    public Date getUpd_date() {
        return upd_date;
    }
 
    public void setUpd_date(Date upd_date) {
        this.upd_date = upd_date;
    }
 
    public String getSearch_type() {
        return search_type;
    }
 
    public void setSearch_type(String search_type) {
        this.search_type = search_type;
    }
 
}


