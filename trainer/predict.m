function [h, d] = predict(X, theta, y)

%results
h = X * theta;

%deviation
d = mean(abs(y - h) ./ y);

end
