from Config import ApiUrl
from RestApi import DataFetcher

class TestAPi:

    def test_api(self):
        self.data_fetcher = DataFetcher()
        self.data_fetcher.fetch_data(ApiUrl.get_url)

    def test_post(self):
        self.data_fetcher = DataFetcher()
        self.data_fetcher.data_post(ApiUrl.post_url, data=ApiUrl.params)
