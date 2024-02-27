import logging
from apis import api


class test_api:

    def test_post_api(self):
        url = "https://reqres.in/api/users?name=aakriti&job=engg"
        dict_data = {"name": "aakriti", "job": "engg"}

        data = api.post(url, dict_data)
        logging.info(data)