import React, { useContext, useState } from 'react'
import MenuItem from './MenuItem'
import { IoMdArrowDropdown } from 'react-icons/io';
import { MdAccountCircle } from "react-icons/md";
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthProvider';
import { IoMdLogOut } from "react-icons/io";

const Menu = (props) => {
  const navigate = useNavigate();

  const isLogin = props.isLogin;

  const gotoLogin=()=>{
    navigate('/login');
  }

  const {userInfo, logout} = useContext(AuthContext);
  console.log("userInfor:", userInfo);

  const logoutRequest = ()=>{
    localStorage.removeItem('token');
    logout();

    window.location.reload();

  }
  //const [isLogin, setIsLogin] = useState(false);

  const menuItems = [

    {
      title: 'Hồ Chí Minh',
      children: ['Hồ Chí Minh', 'Hà Nội', 'Đà Nẵng', 'Cần Thơ', 'Hải Phòng']
    },
    'Thử Quán Mới',
    'Đang Khuyến Mại',

    'Thương Hiệu Quen Thuộc',
    'Cửa Hàng Gần Bạn',
    'Vừa Đặt Gần Đây',
    'Cửa Hàng Chu Đáo',
    'Đăng Nhập'
  ];

  return (
    <div className='flex items-center justify-center w-full h-auto'>
      <nav>
        <ul className="flex space-x-4">
          <li>
            <div className="relative group">
              <button className="flex items-start justify-start text-gray-900 w-[150px] hover:text-red-600">
                Hồ Chí Minh
                <IoMdArrowDropdown className='w-[25px] h-[25px]' />
              </button>
              <ul className="absolute hidden space-y-1 bg-white border border-gray-200 rounded-md shadow-lg group-hover:block">
                <li>
                  <a
                    className="block text-[12px] px-8 py-2 text-gray-900 hover:bg-gray-200"
                    href="#"
                  >
                    Hồ Chí Minh
                  </a>
                </li>
                <li>
                  <a
                    className="block text-[12px] px-8 py-2 text-gray-900 hover:bg-gray-200"
                    href="#"
                  >
                    Hà Nội
                  </a>
                </li>
                <li>
                  <a
                    className="block text-[12px] px-8 py-2 text-gray-900 hover:bg-gray-200"
                    href="#"
                  >
                    Đà Nẵng
                  </a>
                </li>
                <li>
                  <a
                    className="block text-[12px] px-8 py-2 text-gray-900 hover:bg-gray-200"
                    href="#"
                  >
                    Cần Thơ
                  </a>
                </li>
                <li>
                  <a
                    className="block text-[12px] px-8 py-2 text-gray-900 hover:bg-gray-200"
                    href="#"
                  >
                    Hải Phòng
                  </a>
                </li>
              </ul>
            </div>
          </li>
          <li>
            <a className="text-gray-900 hover:text-red-600" href="#">
              Thử Quán Mới
            </a>
          </li>
          <li>
            <a className="text-gray-900 hover:text-red-600" href="#">
              Đang Khuyến Mại
            </a>
          </li>
          <li>
            <a className="text-gray-900 hover:text-red-600" href="#">
              Thương Hiệu Quen Thuộc
            </a>
          </li>
          <li>
            <a className="text-gray-900 hover:text-red-600" href="#">
              Cửa Hàng Gần Bạn
            </a>
          </li>
          <li>
            <a className="text-gray-900 hover:text-red-600" href="#">
              Vừa Đặt Gần Đây
            </a>
          </li>
          <li>
            <a className="text-gray-900 hover:text-red-600" href="#">
              Cửa Hàng Chu Đáo
            </a>
          </li>
          <li>
            {

              isLogin === false ? <a onClick={gotoLogin} className="px-2 py-1 font-bold text-gray-900 bg-gray-200 border-2 rounded-lg hover:text-red-600" href="#">
                Đăng Nhập
              </a> : 

              <div className='flex justify-center'>

<a className="flex items-center justify-center px-2 py-2 font-bold text-gray-900 bg-gray-200 border-2 rounded-lg hover:text-red-600" href="#">
                
                <MdAccountCircle className='mr-5'/> {userInfo.email},Welcome
               </a>

               <a onClick={logoutRequest} className="flex items-center justify-center px-2 py-2 font-bold text-gray-900 bg-gray-200 border-2 rounded-lg hover:text-red-600" href="#">
                
                <IoMdLogOut className='mr-5 text-orange-500'/> Logout
               </a>
              </div>
             
            }

          </li>
        </ul>
      </nav>
    </div>
  )
}

export default Menu