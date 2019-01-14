package com.cospaii.models

interface IGroupItem<P, C> {
    val parent: P?
    val children: C?
}