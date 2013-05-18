function [X, y, m, thetaSize] = loadData(name, columns_count)

columns_count

data = dlmread(name, ' ');
X = data(:, 1:columns_count);
y = data(:, columns_count + 1);
m = length(y); 

%fprintf('First 10 examples from the dataset: \n');
%fprintf(' x = [%.0f %.0f %.0f %.0f %.0f %.0f %.0f %.0f %.0f %.0f], y = %.0f \n', [X(1:10,:) y(1:10,:)]');

%fprintf('\n');
%fprintf('Normalizing Features ...\n');

[X mu sigma] = featureNormalize(X);

X = [ones(m, 1) X];
thetaSize = columns_count + 1;
%X = [ones(m, 1) X(:, 1) + X(:, 2) + X(:, 3)];
%thetaSize = 2;

end
