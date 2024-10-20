package com.ergegananputra.jetpack_compose.domain.entities.base

interface PhotosInterface<ID> {
    var id: ID
    var title: String?
    var description: String?
    var user: String?
    var url: String?
}