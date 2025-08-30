import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'; 
import Navbar from './layout/Navbar';
import Home from './pages/Home'; 
import AddUser from './users/AddUser';
import EditUser from './users/EditUser';
import ViewUser from './users/ViewUser'; // 👈 Import ViewUser

import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />  
          <Route exact path="/adduser" element={<AddUser />}/>
          <Route exact path="/edituser/:id" element={<EditUser/>}/>
          <Route exact path="/view/:id" element={<ViewUser />} />  {/* 👈 Add View route */}
        </Routes>
      </Router> 
    </div>
  );
}

export default App;
