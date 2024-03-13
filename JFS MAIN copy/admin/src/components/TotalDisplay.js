import DisplayVideo from './DisplayVideo';
import Home from'./Home';
import MovieCards from './MovieCards';
import MovieDisplay from './MovieDisplay';
import '../Css/Frontpage.css';
import Footer from './Footer';

function TotalDisplay(){
    return(
        <div classname="page" style={{backgroundColor:'black'}}>
            <Home/>
            <div>
            <DisplayVideo/>
            </div>
            
            
            <MovieCards/>
            <Footer/>
        </div>
    );
}
export default TotalDisplay;