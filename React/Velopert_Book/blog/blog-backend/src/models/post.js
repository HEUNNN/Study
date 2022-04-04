import mongoose from 'mongoose';

const { Schema } = mongoose;

const PostSchema = new Schema({
  // 스키마 객체 생성
  title: String,
  body: String,
  tags: [String], //문자열로 이루어진 배열
  publishedDate: {
    type: Date,
    default: Date.now, //현재 날짜를 기본값으로 지정
  },
  user: {
    _id: mongoose.Types.ObjectId,
    username: String,
  },
});
// 모델 생성
const Post = mongoose.model('Post', PostSchema); // 파라미터: 스키마 이름, 스키마 객체
export default Post;
