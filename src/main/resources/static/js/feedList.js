const feedListObj={
    iuser:1,
    limit:3,
    Page:1,
    url:'',
    makeFeedList: function(){
        fetch(`${this.url}?iuser=${this.iuser}&limit=${this.limit}&page=${this.page}`)
            .then(res => res.json())
            .then(myJson => {
                console.log(myJson)
            })
    }
}


