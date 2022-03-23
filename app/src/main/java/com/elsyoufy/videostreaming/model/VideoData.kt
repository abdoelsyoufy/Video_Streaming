package com.elsyoufy.videostreaming.model

class VideoData {
    var uri : String = ""
    var title : String = ""
    var search : String = ""

    constructor()

    constructor(uri: String, title: String, search: String) {
        this.uri = uri
        this.title = title
        this.search = search
    }

}