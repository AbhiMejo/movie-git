import video from '../Assets/video.mp4';
import '../Css/DisplayVideo.css';
function DisplayVideo(){
    return(
        <div className="container">
            <div className="overlay">
                <video src={video} autoPlay loop muted/>
            </div>
        </div>
    );
}
export default DisplayVideo;