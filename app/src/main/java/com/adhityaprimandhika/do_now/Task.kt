package com.adhityaprimandhika.do_now

class Task {
    private var title : String = ""
    private var desc : String = ""

    constructor(title: String, desc: String) {
        this.title = title
        this.desc = desc
    }

    fun getTitle() : String {
        return title
    }

    fun setTitle(title : String) {
        this.title = title
    }

    fun getDesc() : String {
        return desc
    }

    fun setDesc(desc : String) {
        this.desc = desc
    }
}