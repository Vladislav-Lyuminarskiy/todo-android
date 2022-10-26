package com.htc.infrastructure.entity

/**
 * Базовый тип для всех представлений сущностей доменного слоя для СУБД.
 */
interface EntityBase<T> {
    /**
     * Преобразует представление сущности для СУБД в сущность доменного слоя.
     */
    fun toDomain(): T
}