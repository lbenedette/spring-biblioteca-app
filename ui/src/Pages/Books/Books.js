import React from 'react';
import BookApi from '../../Api/book';

class Books extends React.PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      books: null
    };
  }

  async componentDidMount() {
    const books = await BookApi.getAll();
    this.setState({ books });
  }

  render() {
    const books = this.state.books || [];

    return (
      <div>
        {books.map(book => <div className="book" key={book.id}>{book.title} - {book.author} - {book.yearPublished}</div>)}
      </div>
    );
  }
}

export default Books;