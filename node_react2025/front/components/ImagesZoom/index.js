import PropTypes from "prop-types";
import React,{useState} from "react";
import Slick from 'react-slick';
import {Header,CloseBtn,Overlay,SlickWrapper,ImgWrapper,Global,Indicator} from './style';

const ImagesZoom = ({images,onClose})=>{
  const [currentSlide,setCurrentSlide] = useState(0);
  return(<Overlay>
    <Global/>
    <Header>
      <h1>상세이미지</h1>
      <CloseBtn onClick={onClose}>X</CloseBtn>
    </Header>
    <SlickWrapper>
      <div>
        <Slick
          initialSlide={0}
          beforeChange={(slide,newSlide)=>setCurrentSlide(newSlide)}
          infinite
          arrows={false}
          slidesToShow={1}
          slidesToScroll={1}
        >
          {images.map((v)=>(
            <ImgWrapper key={v.src}>
              <img src={`http://localhost:3065/${v.src}`} art={v.src}/>
            </ImgWrapper>
          ))}
        </Slick>
        <Indicator>
          <div>
            {currentSlide+1}
            {''}
            /
            {images.length}
          </div>
        </Indicator>
      </div>
    </SlickWrapper>
  </Overlay>);
};

ImagesZoom.propTypes = {
  images:PropTypes.arrayOf(PropTypes.object).isRequired,
  onClose:PropTypes.func.isRequired
};

export default ImagesZoom;