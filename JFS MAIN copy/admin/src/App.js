import logo from './logo.svg';
import './App.css';
import Registration from './components/Registration';
import Home from './components/Home';
import { BrowserRouter, Route,Routes } from 'react-router-dom';
import { useState } from 'react';
import Login from './components/Login';
import AdminLogin from './components/AdminLogin';
import AdminDash from './components/AdminDash';
import TheaterDetails from './components/TheaterDetails';
import TheaterDisplay from './components/TheaterDisplay';
import EditTheater from './components/EditTheater';
import MovieAdd from './components/MovieAdd';
import MovieDisplay from './components/MovieDisplay';
import MovieEdit from './components/MovieEdit';
import ShowAdd from './components/ShowAdd';
import ShowDisplay from './components/ShowDisplay';
import ShowEdit from './components/ShowEdit';
import TotalDisplay from './components/TotalDisplay';
import DisplayVideo from './components/DisplayVideo';
import MovieCards from './components/MovieCards';
import Footer from './components/Footer';
import UserShowView from './components/UserShowView';
import Reservation from './components/Reservation';

function App() {
  
  return (
    <div className="App">
      
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<TotalDisplay/>}/>
          <Route path='/Navbar' element={<Home/>} />
          <Route path='/Registration' element={<Registration/>} />
          <Route path='/Login' element={<Login/>}/>
          <Route path='/AdminLogin' element={<AdminLogin/>}/>
          <Route path='/AdminDash' element={<AdminDash/>}/>
          <Route path='/TheaterDetails' element={<TheaterDetails/>}/>
          <Route path='/TheaterDisplay' element={<TheaterDisplay/>}/>
          <Route path="/EditTheater/:id" element={<EditTheater/>}/>
          <Route path='/MovieAdd' element={<MovieAdd/>}/>
          <Route path='/MovieDisplay' element={<MovieDisplay/>}/>
          <Route path="/MovieEdit/:id" element={<MovieEdit/>}/>
          <Route path='/ShowAdd' element={<ShowAdd/>}/>
          <Route path="/ShowDisplay/:id" element={<ShowDisplay/>}/>
          <Route path="/ShowEdit/:id" element={<ShowEdit/>}/>
          <Route path='/DisplayVideo' element={<DisplayVideo/>}/>
          <Route path='/MovieCards' element={<MovieCards/>}/>
          <Route path='/Footer' element={<Footer/>}/>
          <Route path="/UserShowView/:id" element={<UserShowView/>}/>
          <Route path='/Reservation' element={<Reservation/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
