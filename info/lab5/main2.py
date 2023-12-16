import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv("отчет за 4 дня.csv", sep=";")

data = data.drop(["<TICKER>","<PER>", "<VOL>", "<TIME>", "Unnamed: 9"], axis=1)

data_september = data[(data["<DATE>"] == "17.09.2018")]
data_october = data[(data["<DATE>"] == "17.10.2018")]
data_november = data[(data["<DATE>"] == "19.11.2018")]
data_december = data[(data["<DATE>"] == "17.12.2018")]
