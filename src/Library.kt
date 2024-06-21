class Library {
    private val books = mutableListOf<Book>()
    private val borrowedBooks = mutableSetOf<Book>()

    fun addBook(book: Book) {
        if (books.any { it.isbn == book.isbn }) {
            println("Error: Book with ISBN '${book.isbn}' already exists.")
        }
        books.add(book)
    }

    fun findBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author.equals(author, ignoreCase = true) }
    }

    fun findBooksByTitle(title: String): List<Book> {
        return books.filter { it.title.equals(title, ignoreCase = true) }
    }

    fun findBookByISBN(isbn: String): Book? {
        return books.find { it.isbn == isbn }
    }

    fun borrowBook(book: Book): Boolean {
        return if (books.contains(book) && !book.isReference && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book)
            true
        } else {
            false
        }
    }

    fun getBorrowedBooksCount(): Int {
        return borrowedBooks.size
    }
}