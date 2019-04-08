import React, { Component } from 'react';

import HeaderComponent from './components/header';
import ContentComponent from './components/content';
import FooterComponent from './components/footer';

class App extends Component {
  render() {
    return (
      <div className="App">
        <HeaderComponent/>
        <ContentComponent/>
        <FooterComponent/>
      </div>
    );
  }
}

export default App;
