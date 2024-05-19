import axios from "axios";
import React from "react";
import { FaTrash } from "react-icons/fa";
import Swal from "sweetalert2";

const NewsItem= ({ news}) =>{	

	const handleDelete = () => {
		// Perform the delete operation
		const token = localStorage.getItem('token');
		const useremail = localStorage.getItem('useremail');
		const newsId = news.id; // Assuming the news ID is stored in the 'id' property
	
		axios.delete(`http://34.199.170.86:8089/api/v1.0/removeNews/${useremail}/${newsId}`, {
		  headers: {
			Authorization: `Bearer ${token}`
		  }
		})
		.then(response => {
			console.log("REdponse :",response);
		  // Notify the user about successful deletion
		  Swal.fire('Success!', 'News article removed from wishlist.', 'success');
		  // Call onDelete to remove the deleted news item from the UI

		//   onDelete(newsId);
		})
		.catch(error => {
		  console.error('Error removing news article:', error);
		  // Notify the user about the error
		  Swal.fire('Error!', 'Failed to remove news article from wishlist. Please try again.', 'error');
		});
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
					<div className="mt-2" onClick={handleDelete}>
            <FaTrash className="text-danger" />
          </div>					
				</div>
			</div>
		</div>
	);
}

export default NewsItem;
