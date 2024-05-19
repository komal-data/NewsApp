import axios from "axios";
import React, { useState } from "react";
import { FaHeart, FaRegHeart } from "react-icons/fa";
import Swal from "sweetalert2";

const NewsItemWishlist= ({ news }) =>{
   
	const [isAddedToWishlist, setIsAddedToWishlist] = useState(false);    

	const token=localStorage.getItem('token');
	const useremail=localStorage.getItem("useremail");
    console.log("User email:", useremail);
	const handleAddToWishlist = () => {
        if (!token) {
        return;
        }
        if (!useremail) {
            console.error("User email is missing.");
            return;
        }

        setIsAddedToWishlist(!isAddedToWishlist);
        
        const newsObj = {
            Title:news.Title,
            Description:news.Description,
            Source:news.Source,
            Image:news.Image,
            Url:news.Url
        }

        if (!isAddedToWishlist) {
            // Make a POST request to add news article to wishlist
            axios.post(
                "http://34.199.170.86:8089/api/v1.0/addNews",
                {
                useremail,
                news:[newsObj]
                },
                {
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${token}`                    
                }
                }
            )
            .then(response => {
                console.log("News added to wishlist:", response.data.news);
                Swal.fire("Success!", "News added to wishlist successfully!", "success");
                setIsAddedToWishlist(true);
                console.log("news Id : ",news.id);
            })
            .catch(error => {
                console.error("Error adding news to wishlist:", error);
                Swal.fire("Error!", "Failed to add news to wishlist. Please try again.", "error");
            });
        } //else {
        // 	axios.delete(
        // 	  `http://localhost:8089/api/v1.0/removeNews/${useremail}/${news.id}`,
        // 	  {
        // 		headers: {
        // 		  Authorization: `Bearer ${token}`,
        // 		},
        // 	  }
        // 	).then(response => {
        //         console.log("News removed from wishlist:", response.data.news);
        //         Swal.fire("News removed from wishlist successfully!");
        //         setIsAddedToWishlist(false); // Update state to indicate news is not in wishlist
        //     })
        //     .catch(error => {
        //         console.error("Error removing news from wishlist:", error);
        //         Swal.fire("Error!", "Failed to remove news from wishlist. Please try again.", "error");
        //     });
        //   }
	};

	return (
		<div className="col-md-4 mb-4">
			<div className="card my-3">
				<img src={news.Image}
					className="card-img-top" alt="..." style={{height:'300px'}}/>
				<div className="card-body">
					<h5 className="card-title">{news.Title}</h5>
					<p className="w-100 fs-6 
						text-body-secondary 
						text-end">
						- {news.Source}
					</p>
					<p className="card-text">{news.Description}</p>					
					<a href={news.Url} target="_blank" rel="noopener noreferrer" style={{textDecoration:'none'}}>Read More...</a>
					<div className="mt-2" onClick={handleAddToWishlist}>
           				{isAddedToWishlist ? (
           				   <FaHeart className="text-danger" />
           					 ) : (
           				   <FaRegHeart />
          				)}
          			</div>                    
				</div>
			</div>
		</div>
	);
}

export default NewsItemWishlist;
