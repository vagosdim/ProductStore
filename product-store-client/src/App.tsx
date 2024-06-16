import React from 'react';
import './App.css';
import ProductList from './ProductList';

const App: React.FC = () => {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Welcome to My Product App</h1>
      </header>
      <main>
        <ProductList />
      </main>
    </div>
  );
};

export default App;
