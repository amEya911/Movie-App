package eu.tutorials.movieapp.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}