fun main() {
    val library = Library()
    val book1 = Book("Book 1", "Author A", "ISBN1", false)
    val book2 = Book("Book 2", "Author A", "ISBN2", false)
    val book3 = Book("Book 1", "Author B", "ISBN3", true)
    val duplicateBook = Book("Duplicate Book", "Author C", "ISBN1", false)

    // Adding books
    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)
    library.addBook(duplicateBook)  // This should print an error message

    // Finding books by author
    val booksByAuthorA = library.findBooksByAuthor("Author A")
    println("Books by Author A: $booksByAuthorA")

    // Finding books by title
    val booksByTitle = library.findBooksByTitle("Book 1")
    println("Books titled 'Book 1': $booksByTitle")

    // Finding book by ISBN
    val bookByISBN = library.findBookByISBN("ISBN1")
    println("Book with ISBN 'ISBN1': $bookByISBN")

    // Borrowing a book
    val firstBookAuthorA = library.findBooksByAuthor("Author A").first()
    val isBorrowed = library.borrowBook(firstBookAuthorA)
    if (isBorrowed) {
        println("Book borrowed: $firstBookAuthorA")
    } else {
        println("Book not borrowed.")
    }

    // Getting borrowed books count
    val borrowedBooksCount = library.getBorrowedBooksCount()
    println("Number of borrowed books: $borrowedBooksCount")

    // Preventing borrowing of reference books
    val firstBookAuthorB = library.findBooksByAuthor("Author B").first()
    val isReferenceBorrowed = library.borrowBook(firstBookAuthorB)
    println("Reference book borrowed: $isReferenceBorrowed")
}