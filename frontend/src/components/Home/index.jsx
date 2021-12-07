import React, { useEffect } from "react";
import "./style.css";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import AccountCircle from "@mui/icons-material/AccountCircle";
import TextField from "@mui/material/TextField";
import AdapterDateFns from "@mui/lab/AdapterDateFns";
import LocalizationProvider from "@mui/lab/LocalizationProvider";
import DatePicker from "@mui/lab/DatePicker";
import Stack from "@mui/material/Stack";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import moment from "moment";
import axios from "axios";
import InfiniteScroll from "react-infinite-scroll-component";

function Home() {
  const [value, setValue] = React.useState(
    moment(new Date()).format("yyyy-MM-DD")
  );
  const [post, setPost] = React.useState([]);
  const [page, setPage] = React.useState(2);
  const [hasMore, setHasMore] = React.useState(true);
  const auth = JSON.parse(localStorage.getItem("user")) ?? null;

  const onFilterDate = async (date) => {
    let dateClone = moment(date).format("yyyy-MM-DD");
    const res = await axios.get(
      `http://localhost:8080/api/post/list?createDate=${dateClone}&page=${page}&pageSize=3`
    );
    setPost(res.data.content);
    setValue(dateClone);
    setHasMore(true);
    setPage(2);
  };

  const onHeart = async (id) => {
    console.log(page, post);

    const res = await axios.post("http://localhost:8080/api/heart/process", {
      postId: id,
      userId: auth.id,
    });

    if (res.data === "Fail") {
      alert("User can have 3 votes on an item");
    } else {
      const res2 = await axios.get(
        `http://localhost:8080/api/post/list?createDate=${value}&page=1&pageSize=${post.length}`
      );
      setPost(res2.data.content);
    }
  };

  useEffect(() => {
    const getAllFist = async () => {
      const res = await axios.get(
        `http://localhost:8080/api/post/list?createDate=${value}&page=1&pageSize=3`
      );
      setPost(res.data.content);
    };
    getAllFist();
  }, [value]);

  const fetchData = async () => {
    const res = await axios.get(
      `http://localhost:8080/api/post/list?createDate=${value}&page=${page}&pageSize=3`
    );
    if (res.data.content.length === 0 || res.data.content.length < 3) {
      setHasMore(false);
      setPage(2);
    } else {
      console.log(page);
      setPost([...post, ...res.data.content]);
      setPage(page + 1);
    }
  };

  return (
    <>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar style={{ display: "flex", justifyContent: "space-between" }}>
            <div style={{ display: "flex" }}>
              <IconButton
                size="large"
                edge="start"
                color="inherit"
                aria-label="menu"
                sx={{ mr: 2 }}
              >
                <MenuIcon />
              </IconButton>
              <div sx={{ flexGrow: 1 }}>
                <LocalizationProvider dateAdapter={AdapterDateFns}>
                  <Stack spacing={3}>
                    <DatePicker
                      minDate={new Date("1900-01-01")}
                      maxDate={new Date("2023-06-01")}
                      value={value}
                      onChange={(date) => {
                        onFilterDate(date);
                      }}
                      renderInput={(params) => (
                        <TextField {...params} className="datepicker-mui" />
                      )}
                    />
                  </Stack>
                </LocalizationProvider>
              </div>
            </div>
            <div>
              <IconButton
                size="large"
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                color="inherit"
              >
                <AccountCircle />
              </IconButton>
            </div>
          </Toolbar>
        </AppBar>
      </Box>
      <InfiniteScroll
        dataLength={post.length}
        next={fetchData}
        hasMore={hasMore}
        loader={
          <h4 style={{ marginLeft: "10px" }}>
            {post.length > 0 ? "Loading..." : "Data is empty"}
          </h4>
        }
        endMessage={
          <p style={{ textAlign: "center" }}>
            <b>Yay! You have seen it all</b>
          </p>
        }
      >
        {post &&
          post.map((p, index) => (
            <div className="post" key={index}>
              <div>
                <div>{p.title}</div>
                <div>
                  <span>{p.sumHeart}</span>
                  <FavoriteBorderIcon
                    className={
                      p.listHearts.findIndex((i) => (i = auth?.id)) === -1
                        ? "heart"
                        : "red-heart"
                    }
                    onClick={() => {
                      onHeart(p.id);
                    }}
                  />
                </div>
              </div>
              <div>
                <p>{p.concept}</p>
              </div>
            </div>
          ))}
      </InfiniteScroll>
    </>
  );
}

export default Home;
