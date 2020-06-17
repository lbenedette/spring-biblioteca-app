import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <div>
      <span className="navbar__logo-name">Biblioteca</span>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
      </ul>
    </div>
  );
}