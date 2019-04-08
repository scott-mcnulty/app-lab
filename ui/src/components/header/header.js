import React from 'react'

import logo from './logo.svg';
import './header.css';

class HeaderComponent extends React.Component {
  render() {
    return (
      <div>
          <header className="Header-header">
          <img src={logo} className="Header-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="Header-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }
}

export default HeaderComponent;