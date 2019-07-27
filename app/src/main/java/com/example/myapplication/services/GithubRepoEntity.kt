package com.example.myapplication.services

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class GithubRepoEntity(
        @SerializedName("id") var id: Int,
        @SerializedName("name") var name: String,
        @SerializedName("html_url") var url: String
) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<GithubRepoEntity> = object : Parcelable.Creator<GithubRepoEntity> {
            override fun createFromParcel(source: Parcel): GithubRepoEntity = GithubRepoEntity(source)
            override fun newArray(size: Int): Array<GithubRepoEntity?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int,
            source.readString()!!,
            source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(
            dest: Parcel,
            flags: Int
    ) {
        dest.writeValue(id)
        dest.writeString(name)
        dest.writeString(url)
    }
}
