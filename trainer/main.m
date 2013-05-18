%% Initialization
clear ; close all; clc


%% ======================= Part 2: Plotting =======================
fprintf('Loading Data ...\n')
data = load('ex1data1.txt');
X = data(:, 1); y = data(:, 2);
m = length(y); % number of training examples

