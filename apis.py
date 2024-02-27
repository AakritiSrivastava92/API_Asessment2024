import logging
import requests


class api:

    def get(self, url):
        try:
            logging.debug(f"Get the joke api")
            _url = f"{url}"
            _response = requests.get(url=_url)
            _response.raise_for_status()
            _response_json = _response.json()
            keys = ['type', 'setup', 'punchline', 'id']
            for key in keys:
                assert key in _response_json, f'Error the key {key} is not in json'
            print(_response_json)

        except Exception as e:
            print(f"Exception occur: {e}")

    def post(self, url, data):
        try:
            headers = {'Content-Type': 'application/json'}
            _response = requests.post(url, json=data, headers=headers)
            _response.raise_for_status()
            _response_json = _response.json()
            keys = ['id', 'createdAt']
            for key in keys:
                assert key in _response_json, f'Error the key {key} is not in json'
            print(_response_json)

        except Exception as e:
            print(f"An error occurred: {e}")
