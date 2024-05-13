import axios from 'axios';
import React, { useEffect, useState } from 'react'

const CategoryList = () => {


    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/category/findAll');
                setData(response.data.data);
                console.log("response:", response);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);
    return (
        <div className='  flex flex-col mt-[30px] justify-center items-center w-full h-auto '>
            {/* 
            <div className='flex justify-center w-4/5 h-auto'>

                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>

            </div>


            <div className='flex justify-center w-4/5 h-auto'>

                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>
                <div className='flex flex-col items-center justify-center h-auto w-1/10 '>

                    <img src='https://tea-3.lozi.vn/v1/images/resized/category-web-3-1590571350?w=100&type=f' className='w-4/5' />
                    <div>
                        <p>Ăn vặt</p>
                    </div>

                </div>

            </div> */}

            {/* <div className="flex flex-wrap">
                {data.map((item, index) => (
                    <div key={index} className="flex flex-col items-center justify-center h-auto w-1/10">
                        <img src={item.icon} className="w-3/5" />
                        <div>
                            <p>{item.name}</p>
                        </div>
                    </div>
                ))}
            </div> */}

            <div className='flex w-[80%]'>

            <div className="grid grid-cols-10 gap-4">
                {data.map(item => (
                    <div key={item.id} className="flex flex-col items-center">
                        <img src={item.icon} alt="" className="w-24 h-24" />
                        <span className="mt-2">{item.name}</span>
                    </div>
                ))}
            </div>

            </div>

           

        </div>
    )
}

export default CategoryList