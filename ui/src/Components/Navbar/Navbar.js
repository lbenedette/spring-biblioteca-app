import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div>
      <span className="navbar__logo-name">Biblioteca</span>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/books">Books</Link>
        </li>
      </ul>
    </div>
  );
}

export default Navbar;