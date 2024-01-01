// Desc: 封装请求
const baseURL='http://localhost:8081/'
function request(options) {
    return new Promise((resolve, reject) => {
        wx.request({
            url:  baseURL+ options.url,
            method: options.method,
            data: options.data,
            header: {
                'Content-Type': 'application/json',
                'Accept': '*/*',
                ...options.headers
            },
            success: function(res) {
                if (res.statusCode === 200) {
                    resolve(res.data);
                } else {
                    reject(res);
                }
            },
            fail: function(error) {
                reject(error);
            }
        });
    });
}

export default request;