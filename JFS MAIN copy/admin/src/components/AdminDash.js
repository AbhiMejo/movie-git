import Home from './Home';
import { useState } from 'react';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import TheaterDetails from './TheaterDetails';
import TheaterDisplay from './TheaterDisplay';
import MovieAdd from './MovieAdd';
import MovieDisplay from './MovieDisplay';
import ShowAdd from './ShowAdd';
import ShowDisplay from './ShowDisplay';
import { Button } from 'react-bootstrap';

function AdminDash(){
    const [key, setKey] = useState('home');

    return(
      
      <div>
        <div className='main' style={{}}>
        <Tabs
      id="controlled-tab-example"
      activeKey={key}
      onSelect={(k) => setKey(k)}
      className="mb-3"
    >
      <Tab eventKey="TheaterDetails" title="TheaterDetails">
      <TheaterDisplay/>
        <TheaterDetails/>
      </Tab>
      <Tab eventKey="Movies" title="Movies">
        <MovieDisplay/>
       <MovieAdd/>
      </Tab>
      <Tab eventKey="Show" title="Show" >
        <ShowDisplay/>
        <ShowAdd/>
      </Tab>
      
    </Tabs>
      </div><br/><br/>
      <Button href='/'>Home</Button>
      </div>
      
        
    );
}
export default AdminDash;