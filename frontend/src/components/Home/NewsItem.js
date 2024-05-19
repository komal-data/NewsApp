import React from "react";

const NewsItem= ({ news}) =>{	

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
				</div>
			</div>
		</div>
	);
}

export default NewsItem;
