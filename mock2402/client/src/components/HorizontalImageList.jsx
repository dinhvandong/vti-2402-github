import React, { useEffect, useRef } from 'react'
import { FaArrowLeft } from "react-icons/fa";
import { FaArrowRight } from "react-icons/fa";
const HorizontalImageList = () => {
    const imageListRef = useRef(null);

    const scrollLeft = () => {
        imageListRef.current.scrollLeft -= imageListRef.current.offsetWidth;
    };

    const scrollRight = () => {
       // imageListRef.current.scrollLeft += imageListRef.current.offsetWidth;

       const { scrollLeft, scrollWidth, offsetWidth } = imageListRef.current;

       if (scrollLeft < scrollWidth - offsetWidth) {
         // Scroll to the next item
         imageListRef.current.scrollLeft += offsetWidth;
       } else {
         // Reached the end, scroll back to the beginning
         imageListRef.current.scrollLeft = 0;
       }
    };


    useEffect(() => {
        const interval = setInterval(scrollRight, 2000);
    
        return () => {
          clearInterval(interval);
        };
      }, []);

    const images = [
        'https://tea-3.lozi.vn/v1/images/resized/banner-mobile-3313-1664611060?w=393&type=o',
        'https://tea-3.lozi.vn/v1/images/resized/banner-mobile-5069-1705560040?w=393&type=o',
        'https://tea-3.lozi.vn/v1/images/resized/banner-mobile-5632-1705560074?w=393&type=o',
        'https://tea-3.lozi.vn/v1/images/resized/banner-mobile-5071-1711613752?w=393&type=o',
        'https://tea-3.lozi.vn/v1/images/resized/banner-mobile-5261-1711612959?w=393&type=o',
        // Add more image URLs as needed
    ];

    return (
        <div className="mt-[30px] flex items-center justify-center w-full">

            <button
                onClick={scrollLeft}
                className="left-0 p-3 mr-3 transform -translate-y-1/2 bg-gray-500 rounded-full top-1/2"
            >
                <FaArrowLeft className='text-white'/>
            </button>
            <div
                ref={imageListRef}
                className="mt-[50px] flex justify-center w-4/5 items-center space-x-4 overflow-x-auto"
            >

                {images.map((imageUrl, index) => (
                    <div key={index} className="flex-shrink-0 w-1/3 h-[200px]">
                        <img
                            src={imageUrl}
                            alt={`Image ${index + 1}`}
                            className="w-full h-full bg-cover"
                        />
                    </div>
                ))}
            </div>

            <button
                onClick={scrollRight}
                className="right-0 p-3 ml-3 transform -translate-y-1/2 bg-gray-500 rounded-full top-1/2"
            >
                <FaArrowRight className='text-white'/>
            </button>
        </div>
    );
};

export default HorizontalImageList