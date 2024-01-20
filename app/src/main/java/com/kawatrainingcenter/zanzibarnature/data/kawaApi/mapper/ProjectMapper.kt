package com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.ImageUrls
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.ProjectEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.ProjectsEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Projects
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ProjectMapper @Inject constructor() {

    fun map(entity: ProjectEntity): Result<Project> {
        return runCatching {

            //The images from the backend are a serialized string, this method below converts them into a List<String>
            val serializedImageURLs = entity.serializedImageURLs
            val imageUrls = Json.decodeFromString<ImageUrls>(serializedImageURLs)
            val image = imageUrls.BannerImage

            Project(
                id = entity.rowKey,
                name = entity.title,
                description = entity.mainText,
                image = image
            )
        }
    }

    fun mapList(entity: ProjectsEntity): Result<Projects> {
        return runCatching {
            Projects(
                projects = entity.item2.map { map(it).getOrThrow() }
            )
        }
    }
}