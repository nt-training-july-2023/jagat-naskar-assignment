import './App.css';
import RegistrationPage from './components/registration';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p>This is header section</p>
        <hr></hr>
      </header>
      <main>
        <RegistrationPage/>
        <hr></hr>
      </main>
      <footer>
      <p>This is footer section</p>
      <hr></hr>
      </footer>
    </div>
  );
}

export default App;
