/*
1. Cài các module trong Nodejs(trong terminal):
npm install -g mongoose

2.Cài mongoDB: brew install mongo
Tạo thư mục chứa cơ sở dữ liệu mongoDB:
mkdir ~/Documents/mongoDatabase
Start database:  
/usr/local/Cellar/mongodb-community@4.0/4.0.12/bin/mongod --dbpath ~/Documents/mongoDatabase --port 27018
Để nguyên cửa số terminal, mở cửa sổ khác để thao tác lệnh, google search, cài Robo3T
Mở Robo3T, tạo mới 1 connection, chọn cổng 27018, thử connect, nhìn thấy 2 instance: admin và local là được

3.Tạo user đăng nhập MongoDB: 
Mở Robo3T, chuột phải vào admin, chọn Open Shell, gõ các lệnh:
use mongoDatabase
db.createUser({user: 'hoangnd',pwd: '123456',roles: [{role:"readWrite",db: 'mongoDatabase'}], mechanisms:["SCRAM-SHA-1"]})
Khởi động lại Database bằng lệnh: mongod --dbpath ~/Documents/mongoDatabase --port 27018 --auth 

4.Khởi động server Nodejs trên máy local(máy laptop đang dùng)
Mở cửa sổ terminal mới, gõ: cd “đường dẫn thư mục Server”, xoá thư mục node_modules: rm -rf node_modules
Cài lại package trong Nodejs: npm install
Chạy server: node index.js 
thấy hiện thành công là được

*/
const mongoose = require('mongoose')
//Kết nối CSDL MongoDB
const connectDatabase = async () => {
    try {
        let uri = 'mongodb://hoangnd:123456@127.0.0.1:27018/mongoDatabase'
        let options = {
            connectTimeoutMS: 10000,// 10 giây
			useNewUrlParser: true,
            useCreateIndex: true,
            poolSize: 10, // Maintain up to 10 socket connections
        }
        await mongoose.connect(uri, options)
        console.log('Connect Mongo Database successfully')
    } catch(error) {
        console.log(`Cannot connect Mongo. Error: ${error}`)
    }
}
connectDatabase()
module.exports = {
    mongoose
}