package com.ergegananputra.jetpack_compose.domain.entities.remote.response

import com.ergegananputra.jetpack_compose.domain.entities.base.PhotosInterface

class PhotoResponse(
    override var id: Int,
    override var title: String?,
    override var description: String?,
    override var user: String?,
    override var url: String?
) : PhotosInterface<Int> {}