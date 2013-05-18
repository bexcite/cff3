%% Initialization
clear ; close all; clc

columns_count = 10;

%fprintf('Loading Data ...\n')
[X y m] = loadData('data-input', columns_count);

%fprintf('Running gradient descent ...\n');

% Choose some alpha value
alpha = 0.01;
num_iters = 3000;

% Init Theta and Run Gradient Descent 
theta = zeros(columns_count + 1, 1);
[theta, J_history] = gradientDescentMulti(X, y, theta, alpha, num_iters);

%fprintf('Theta computed from gradient descent: \n');
%fprintf(' %f \n', theta);
%fprintf('\n');

[p, d] = predict(X, theta, y);
computeCostMulti(X, y, theta)

fprintf(['Traininig data error: ' ...
         ':\n %f\n'], d);

[X y m] = loadData('data-test', columns_count);
[p, d] = predict(X, theta, y);
computeCostMulti(X, y, theta)

fprintf(['Test data error: ' ...
         ':\n %f\n'], d);
