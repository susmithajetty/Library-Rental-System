let books = [];

function addBook() {
  const book = {
    id: bookId.value,
    title: title.value,
    author: author.value,
    available: true
  };
  books.push(book);
  showMessage("✅ Book added successfully");
}

function rentBook() {
  const book = books.find(b => b.id == actionId.value);
  if (book && book.available) {
    book.available = false;
    showMessage("📕 Book rented successfully");
  } else {
    showMessage("❌ Book not available");
  }
}

function returnBook() {
  const book = books.find(b => b.id == actionId.value);
  if (book && !book.available) {
    book.available = true;
    showMessage("📗 Book returned successfully");
  } else {
    showMessage("❌ Invalid return");
  }
}

function showAll() {
  if (books.length === 0) {
    showMessage("No books found");
    return;
  }
  output.innerHTML = books.map(b =>
    `<p>${b.id} | ${b.title} | ${b.author} | ${b.available ? "Available" : "Rented"}</p>`
  ).join("");
}

function showAvailable() {
  const available = books.filter(b => b.available);
  if (available.length === 0) {
    showMessage("No available books");
    return;
  }
  output.innerHTML = available.map(b =>
    `<p>${b.title} by ${b.author}</p>`
  ).join("");
}

function showMessage(msg) {
  output.innerHTML = `<p>${msg}</p>`;
}
